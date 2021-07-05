package cn.chenzw.springboot.druid.code.parser;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.stat.TableStat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class SqlParserTests {

    @Test
    public void testCreate() {
        String sql = "CREATE TABLE 'sys_user' (\n" +
                "  'user_id' int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',\n" +
                "  'user_name' varchar(255) NOT NULL COMMENT '用户名',\n" +
                "  'status' tinyint(1) NOT NULL COMMENT '状态',\n" +
                "  'create_time' datetime NOT NULL COMMENT '创建时间',\n" +
                "  PRIMARY KEY ('user_id')\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息'";


        // 新建 MySQL Parser
        SQLStatementParser parser = new MySqlStatementParser(sql);

        // 使用Parser解析生成AST，这里SQLStatement就是AST
        SQLStatement sqlStatement = parser.parseStatement();

        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        sqlStatement.accept(visitor);

        log.info("tables => {}", visitor.getTables());
        log.info("columns => {}", visitor.getColumns());

        for (TableStat.Column column : visitor.getColumns()) {
            System.out.println(column.getFullName());
            System.out.println(column.getAttributes());
            System.out.println(column.getDataType());
        }

    }
}
