class CheckValidation {
    
    /**
     * isDateメソッド:
     * パラメータが日付ならtrueを返し、それ以外はfalseを返す。
     * @param Date 日付?
     * @return パラメータが日付ならtrue
     */
    fun isDate(Date: String): Boolean {
        return try {
            val dtf: java.time.format.DateTimeFormatter =
                java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd")
            dtf.format(java.time.LocalDate.parse(Date, dtf))
            true
        } catch (dtp: java.time.format.DateTimeParseException) {
            false
        }
    }

    /**
     * isPhoneCodeメソッド:
     * パラメータが電話番号ならtrueを返し、それ以外はfalseを返す。
     * @param phoneCode 電話番号?
     * @return パラメータが電話番号ならtrue
     */
    fun isPhoneCode(phoneCode: String): Boolean {
        //記号なし
        var isSuccess = checkPattern(phoneCode, "^0[-0-9]{11,12}$")
        if (isSuccess == false) {
            //記号あり
            isSuccess = checkPattern(phoneCode, "^^0[0-9]{9,10}$")
        }
        return isSuccess
    }

    /**
     * isEmailメソッド:
     * パラメータがメールアドレスならtrueを返し、それ以外はfalseを返す。
     * @param email メールアドレス?
     * @return パラメータがメールアドレスならtrue
     */
    fun isEmail(email: String): Boolean {
        var isSuccess = checkPattern(
            email,
            "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$"
        )
        return isSuccess
    }

    /**
     * isZipCodeメソッド:
     * パラメータが郵便番号ならtrueを返し、それ以外はfalseを返す。
     * @param zipCode 郵便番号?
     * @return パラメータが郵便番号ならtrue
     */
    fun isZipCode(zipCode: String): Boolean {
        //ハイフンあり
        var isSuccess = checkPattern(zipCode, "^[0-9]{3}-[0-9]{4}$")
        if (isSuccess == false) {
            //記号あり
            isSuccess = checkPattern(zipCode, "^〒\\s[0-9]{3}-[0-9]{4}$")
            if (isSuccess == false) {
                //ハイフンなし
                isSuccess = checkPattern(zipCode, "^[0-9]{7}$")
            }
        }
        return isSuccess
    }

    /**
     * isZenkakuメソッド:
     * パラメータが全角文字ならtrueを返し、それ以外はfalseを返す。
     * @param str 文字列
     * @return パラメータが全角文字ならtrue
     */
    fun isZenkaku(str: String): Boolean {
        var isSuccess = checkPattern(str, "^[^ -~｡-ﾟ]+$")
        return isSuccess
    }

    /**
     * checkPwdメソッド:
     * パラメータにパスワードに使えない文字が含まれていない場合、trueを返し、それ以外はfalseを返す。
     * 小文字の半角アルファベット,大文字の半角アルファベット,半角数字,記号をすべて含む
     * @param pwd 文字列
     * @return パラメータが使用可能文字のみの場合true
     */
    fun checkPwd(pwd: String): Boolean {
        var isSuccess =
            checkPattern(pwd, "^$|^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!-/:-@\\[-`{-~])[!-~]*")
        return isSuccess
    }

    /**
     * checkPatternメソッド:
     * 文字列がパラメータで指定された正規表現に一致したらtrueを返し、それ以外はfalseを返す。
     * @param str 文字列
     * @param regularExpression　正規表現
     * @return 一致したらtrueを返す。
     */
    private fun checkPattern(str: String, regularExpression: String): Boolean { 
        val pattern: java.util.regex.Pattern = java.util.regex.Pattern.compile(regularExpression)
        val matcher: java.util.regex.Matcher = pattern.matcher(str)
        return if (matcher.find()) {
            true
        } else false
    }
}