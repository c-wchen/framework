package com.wchen.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * 自定义提示
 */
@Component
public class SimplePromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("wchen world"+ ":>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}

