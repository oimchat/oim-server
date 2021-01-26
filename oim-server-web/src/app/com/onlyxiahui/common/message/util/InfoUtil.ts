class InfoUtil {

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

export default InfoUtil;
