PrimeFaces.validator['UnicodeValidator'] = {
    regex: /^[-'´`\s\p{L}]+$/u,

  MESSAGE_ID: 'invalid.unicode',

    validate: function (element, value) {
        if (!this.regex.test(value)) {
            throw PrimeFaces.util.ValidationContext.
            getMessage(this.MESSAGE_ID, element.data('param'));
        }
    }
};

PrimeFaces.validator['ValidCVC'] = {
    MESSAGE_ID: 'invalid.cvc',

    validate: function (element, value) {
        alert(value);
        console.log("ValidCVC called for value:", value);

        var forCardMenu = element.data('forcardmenu');
        console.log("forCardMenu selector:", forCardMenu);

        var selOption = null;
        if (forCardMenu) {
            try {
                var component = PrimeFaces.expressions.SearchExpressionFacade.resolveComponentsAsSelector(forCardMenu);
                if (component.length > 0) {
                    // p:selectOneMenu renders a hidden select
                    selOption = component.is('select') ? component.val() : component.find('select').val();
                }
            } catch (e) {
                console.error("Error resolving components for ValidCVC:", e);
            }
        }

        console.log("Detected card option:", selOption);

        var valid = true;
        // value might be a string, convert to check length
        var strValue = value ? value.toString() : "";

        if (selOption === 'MCD') {
            valid = /^\d{3}$/.test(strValue);
        } else if (selOption === 'AMEX') {
            valid = /^\d{4}$/.test(strValue);
        }

        console.log("Validation result:", valid);

        if (!valid) {
            throw PrimeFaces.util.ValidationContext.getMessage(this.MESSAGE_ID);
        }
    }
};