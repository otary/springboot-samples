package cn.chenzw.springboot.druid.code.parser;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLName;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlSelectIntoStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SQLASTVisitorAdapter;
import com.alibaba.druid.stat.TableStat;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

@Slf4j
public class SqlParser {

    public static void main(String[] args) {
        String sql = "select u.id, u.username, u.password, d.deptname from users u, dept d where u.dept_id = d.id and u.id = 1 and name = ming group by uid limit 1,200 order by ctime";

        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

        // 使用Parser解析生成AST，这里SQLStatement就是AST
        SQLStatement sqlStatement = parser.parseStatement();

        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        sqlStatement.accept(visitor);

        log.info("getTables: {}", visitor.getTables());
        log.info("getParameters: {}", visitor.getParameters());
        log.info("getColumns: {}", visitor.getColumns());
        log.info("getOrderByColumns: {}", visitor.getOrderByColumns());
        log.info("getGroupByColumns: {}", visitor.getGroupByColumns());
        log.info("getConditions => {}", visitor.getConditions());

        Map<TableStat.Name, TableStat> tables = visitor.getTables();
        for (Map.Entry<TableStat.Name, TableStat> tableStatEntry : tables.entrySet()) {
            log.info("Name => {}", tableStatEntry.getKey().getName());
            log.info("TableStat => {}", tableStatEntry.getValue());
        }

        // 使用select访问者进行select的关键信息打印
        SelectPrintVisitor selectPrintVisitor = new SelectPrintVisitor();
        sqlStatement.accept(selectPrintVisitor);

        // 最终sql输出
        StringWriter out = new StringWriter();
        TableNameVisitor outputVisitor = new TableNameVisitor(out);
        sqlStatement.accept(outputVisitor);

        log.info(" => {}", out.toString());
    }


    /**
     * 查询语句访问者
     */
    public static class SelectPrintVisitor extends SQLASTVisitorAdapter {

        @Override
        public boolean visit(SQLSelectQueryBlock x) {
            List<SQLSelectItem> selectItemList = x.getSelectList();
            selectItemList.forEach(selectItem -> {
                log.info("attr => {}", selectItem.getAttributes());
                log.info("expr => {}", SQLUtils.toMySqlString(selectItem.getExpr()));
            });

            log.info("table: {}", SQLUtils.toMySqlString(x.getFrom()));
            log.info("where: {}", SQLUtils.toMySqlString(x.getWhere()));
            log.info("order by: {}", SQLUtils.toMySqlString(x.getOrderBy().getItems().get(0)));
            log.info("limit: {}", SQLUtils.toMySqlString(x.getLimit()));

            return true;
        }

    }

    /**
     * 数据库表名访问者
     */
    public static class TableNameVisitor extends MySqlOutputVisitor {

        public TableNameVisitor(Appendable appender) {
            super(appender);
        }

        @Override
        public boolean visit(SQLExprTableSource x) {
            SQLName table = (SQLName) x.getExpr();
            String tableName = table.getSimpleName();

            // 改写tableName
            print0("new_" + tableName.toUpperCase());

            return true;
        }

    }


}
