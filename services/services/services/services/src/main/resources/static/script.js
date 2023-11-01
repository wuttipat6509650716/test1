function validateAndAlert() {
    var postcodeInput = document.getElementById("postalCode").value;
    var IdInput = document.getElementById("studentId").value;
    var mobilePhoneInput = document.getElementById("mobilePhone").value;

    var isValidPostCode = /^\d{5}$/.test(postcodeInput);
    var isValidId = /^\d{10}$/.test(IdInput);
    var isValidmobilePhone = /^\d{10}$/.test(mobilePhoneInput);

    if (!isValidPostCode) {
        alert("รหัสไปรษณีย์ต้องเป็นตัวเลข 5 หลัก");
        event.preventDefault();
    } else if(!isValidId){
        alert("เลขทะเบียนนักศึกษาต้องเป็นตัวเลข 10 หลัก");
        event.preventDefault();
    } else if(!isValidmobilePhone){
        alert("เบอร์โทรศัพท์ต้องเป็นตัวเลข 10 หลัก");
        event.preventDefault();
    }

    var userConfirmation = confirm("คุณแน่ใจหรือไม่ที่ต้องการทำการ submit ฟอร์มนี้?");
    if (userConfirmation) {
        document.getElementById("myForm").submit();
    } else {
        alert("คุณยกเลิกการ submit ฟอร์ม");
    }
}