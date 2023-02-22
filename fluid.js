"use strict";

const fluid = function () {
};

fluid.prototype = {
    init: function () {
        var oHead = document.getElementsByTagName('HEAD').item(0);
        var oScript= document.createElement("script");
        oScript.type = "text/javascript";
        oScript.src="https://code.jquery.com/jquery-3.6.3.min.js";
        oHead.appendChild( oScript);
        console.log("init fluid");
        window.addEventListener('message', function (e) {
            try {
                let data = JSON.parse(e.data)
                if (data.from === 'auth' && data.event === 'close') {
                    const $ = window.jQuery;
                    $(".fluid-xb-bg").hide()
                }
            } catch (error) {
                console.log(error)
            }
        })
    },
    openDialog: function (url) {
        if (isMobile()) {
            window.open(url)
        } else {
            var $ = window.jQuery
            var dialogDom = $(
                '<div class="fluid-xb-bg">'+
                '<div class="fluid-xb-box">'+
                '<iframe src="' + url + '" class="fluid-xb-iframe-box" marginwidth="0" marginheight="0"></iframe>'+
                '</div>'+
                '</div>'
            )
            $("body").append(dialogDom)
            $(".fluid-xb-close").click(function (){
                $(".fluid-xb-bg").hide()
            })
        }
        console.log($)
    }
}

function isMobile() {
    let flag = navigator.userAgent.match(
        /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
    );
    return flag;
}

module.exports = {fluid}
