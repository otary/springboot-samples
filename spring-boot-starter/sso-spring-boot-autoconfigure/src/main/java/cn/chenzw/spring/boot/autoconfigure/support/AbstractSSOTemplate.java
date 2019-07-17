package cn.chenzw.spring.boot.autoconfigure.support;

import cn.chenzw.spring.boot.autoconfigure.SSOProperties;

/**
 * @author chenzw
 */
public abstract class AbstractSSOTemplate {

    private SSOProperties properties;

    public AbstractSSOTemplate(SSOProperties properties) {
        this.properties = properties;
    }

   public SSOProperties getProperties(){
        return properties;
   }

}
