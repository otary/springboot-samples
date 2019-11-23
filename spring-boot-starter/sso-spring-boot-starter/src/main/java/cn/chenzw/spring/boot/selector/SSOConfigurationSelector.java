package cn.chenzw.spring.boot.selector;

import cn.chenzw.spring.boot.annotation.EnableSSO;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

/**
 *
 */
public class SSOConfigurationSelector extends AdviceModeImportSelector<EnableSSO> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {

        return new String[]{

        };
    }
}
