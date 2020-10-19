const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);

exports.sendNotificationToTopic = functions.firestore.document('VDR/Status').onWrite(async (event) =>{
    //let docID = event.after.id;
    //const newValue = change.after.data('Real Time');
    //const previousValue = change.before.data();
    
    
    const title = event.after.data()['Real Time'];
    //print (title);
    const content = event.before.data()['Real Time'];
    //print (content);
    var message = {
        notification: {
            title: title,
            body: content,
            sound: "default"
        }
    };
    let response = await admin.messaging().sendToTopic("pushNotification", message);
    console.log(response, message);
});
