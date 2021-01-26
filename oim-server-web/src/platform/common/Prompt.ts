import Element from 'element-ui';


export default class Prompt {

    public static message(info: any, successText: string, warningText: string) {
        let message = '';
        if (info) {
            if (info.success) {
                message = Prompt.getDefaultPromptText(info);
                if (!message || '' === message) {
                    message = successText;
                }
                if (message) {
                    Element.Notification.success(message);
                }
            } else {
                message = Prompt.getDefaultErrorText(info);
                if (!message || '' === message) {
                    message = warningText;
                }
                if (message) {
                    Element.Notification.error(message);
                }
            }
        } else {
            if (warningText) {
                Element.Notification.error(warningText);
            }
        }
    }

    public static notice(message: string, title?: string, type?: string) {
        type = type ? type : 'info';

        if ('info' === type) {
            title = title || '信息';
            Element.Notification.info({
                title,
                message,
            });
        }
        if ('success' === type) {
            title = title || '成功';
            Element.Notification.success({
                title,
                message,
            });
        }
        if ('warn' === type) {
            title = title || '警告';
            Element.Notification.warning({
                title,
                message,
            });
        }
        if ('error' === type) {
            title = title || '错误';
            Element.Notification.error({
                title,
                message,
            });
        }
    }

    public static info(message: string, title?: string) {
        title = title || '信息';
        Element.Notification.info({
            title,
            message,
        });
    }

    public static success(message: string, title?: string) {
        title = title || '成功';
        Element.Notification.success({
            title,
            message,
        });
    }

    public static warning(message: string, title?: string) {
        title = title || '警告';
        Element.Notification.warning({
            title,
            message,
        });
    }

    public static error(message: string, title?: string) {
        title = title || '错误';
        Element.Notification.error({
            title,
            message,
        });
    }

    public static getDefaultErrorText(info: any) {
        let text = '';
        if (info) {
            const warnings = info.warnings;
            const errors = info.errors;
            if (warnings && warnings.length > 0) {
                for (const warning of warnings) {
                    text = text + warning.text + '\n';
                }
            } else if (errors && errors.length > 0) {
                for (const error of errors) {
                    text = text + error.text + '\n';
                }
            }
        }
        return text;
    }

    public static getDefaultPromptText(info: any) {
        let text = '';
        if (info) {
            const prompts = info.prompts;
            if (prompts && prompts.length > 0) {
                for (const prompt of prompts) {
                    text = text + prompt.text + '\n';
                }
            }
        }
        return text;
    }
}
