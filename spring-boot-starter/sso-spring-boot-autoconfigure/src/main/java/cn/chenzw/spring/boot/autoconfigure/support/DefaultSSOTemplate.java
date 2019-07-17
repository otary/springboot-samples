package com.ffcs.itm.sso.support;

import cn.chenzw.spring.boot.autoconfigure.SSOProperties;
import cn.chenzw.spring.boot.autoconfigure.support.AbstractSSOTemplate;

/**
 * 默认单点登录处理类
 *
 * @author chenzw
 */
public class DefaultSSOTemplate extends AbstractSSOTemplate {

    public DefaultSSOTemplate(SSOProperties properties) {
        super(properties);
    }

    @Override
    public SSOProperties getProperties() {
        return super.getProperties();
    }
}
