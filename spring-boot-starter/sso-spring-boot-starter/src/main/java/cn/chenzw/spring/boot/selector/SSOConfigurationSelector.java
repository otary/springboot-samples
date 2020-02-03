package cn.chenzw.spring.boot.selector;

import cn.chenzw.spring.boot.annotation.EnableSSO;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

/**
 * 动态注册Bean( 传递AdviceMode参数)
 * @author chenzw
 */
public class SSOConfigurationSelector extends AdviceModeImportSelector<EnableSSO> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {

        return new String[]{

        };
    }
}
