var sendAjaxJsonHeaderWithLoading = function(Method, Url, jData, Data, Async, ContentType, callback){
    if(ContentType == ""){
        ContentType = "application/x-www-form-urlencoded; charset=UTF-8";
    }
    $.ajax({
        type: Method
        , url: Url
        , data: jData
        , headers : Data
        , async : Async
        , contentType: ContentType
        , beforeSend: function() {
        }
        , success: function (res) {
            if (typeof callback == 'function') {
                callback(res);
            }
        },
        error : function(request, textStatus, errorThrown) {
            alert("An error has occured. Please try again later."+request+textStatus+errorThrown);
        }
    });
}