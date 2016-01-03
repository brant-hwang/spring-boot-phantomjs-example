var stylesheets = document.styleSheets;
for (i in stylesheets) {
        var stylesheet = stylesheets[i];
        var rules = stylesheet.cssRules;
        for (j in rules) {
                var rule = rules[j];
                if (rule instanceof CSSFontFaceRule) {
                        var src = rule.style.getPropertyValue('src');
                        var srcSansLocal = src.replace(/local\([^\)]+?\)\s*,\s*/i, '');
                        rule.style.setProperty('src', srcSansLocal, null);
                }
        }
}
