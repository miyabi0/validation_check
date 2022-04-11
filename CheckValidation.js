/**
* isPhoneCodeメソッド:
* パラメータが電話番号ならtrueを返し、それ以外はfalseを返す。
* @param phoneCode 電話番号?
* @return パラメータが電話番号ならtrue
*/
function isPhoneCode(phoneCode){
    //記号なし
    isSuccess = checkPattern(phoneCode,"^0[-0-9]{11,12}$");
    if(isSuccess == false){
        //記号あり
        isSuccess = checkPattern(phoneCode, "^^0[0-9]{9,10}$");
    }
    return isSuccess;
}

/**
* isEmailメソッド:
* パラメータがメールアドレスならtrueを返し、それ以外はfalseを返す。
* @param email メールアドレス?
* @return パラメータがメールアドレスならtrue
*/
function isEmail(email){
    return isSuccess = checkPattern(email,"^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$");
}

/**
* isZipCodeメソッド:
* パラメータが郵便番号ならtrueを返し、それ以外はfalseを返す。
* @param zipCode 郵便番号?
* @return パラメータが郵便番号ならtrue
*/
function isZipCode(zipCode){
	//ハイフンあり
	isSuccess = checkPattern(zipCode,"^[0-9]{3}-[0-9]{4}$");
	if(isSuccess == false){
	    //記号あり
		isSuccess = checkPattern(zipCode, "^〒\\s[0-9]{3}-[0-9]{4}$");
		if (isSuccess == false) {
		//ハイフンなし
		isSuccess = checkPattern(zipCode, "^[0-9]{7}$");
		}
	}
	return isSuccess;
}

/**
* isZenkakuメソッド:
* パラメータが全角文字ならtrueを返し、それ以外はfalseを返す。
* @param str 文字列
* @return パラメータが全角文字ならtrue
*/
function isZenkaku(str){
	return isSuccess = checkPattern(str,"^[^ -~｡-ﾟ]+$");
}

/**
* checkPatternメソッド:
* 文字列がパラメータで指定された正規表現に一致したらtrueを返し、それ以外はfalseを返す。
* @param str 文字列
* @param regularExpression　正規表現
* @return 一致したらtrueを返す。
*/
function checkPattern(str,regularExpression) {
    if (str.match(regularExpression)) {
        return true;
    }else{
        return false;
    }
}
