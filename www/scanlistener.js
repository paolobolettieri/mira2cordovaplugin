var scan = {
    startscan: function(customerID, appID, isContinuous, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'com.visualengines.mira.cordova.ScanListenerPlugin', // mapped to our native Java class called "Calendar"
            'scanlistener', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "customerID": customerID,
                "appID": appID,
                "isContinuous": isContinuous
            }]
        );
     }
}
module.exports = scan;