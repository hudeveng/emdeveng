$("#otp-form").validate({
    rules: {
        otp: "required"
    },
    messages: {
        otp: "Enter the OTP Code"
    },
    submitHandler: function(form) {
        form.submit();
    }
});

$("#register-form").validate({
                rules: {
                    firstname: {
                        required: true,
                        lettersonly: true
                    },
                    lastname: "required",
                    ownername: "required",
                    shopname: "required",
                    shoplicensenumber: "required",
                    address: "required",
                    phonenumber: {
                        required: true,
                        number: true,
                        lettersonly: false,
                        minlength: 10,
                        maxlength: 10
                    },
                    city: "required",
                    state: "required",
                    country: "required",
                    email: {
                        required: true,
                        email: true
                    },
                    username: {
                        required: true,
                        minlength: 5
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    confirmpassword: {
                        required: true,
                        minlength: 5,
                        equalTo: "#password"
                    },
                    gender: "required",
                    agree: "required"
                },
                messages: {
                    firstname: "Please enter your First Name",
                    lastname: "Please enter your Last Name",
                    ownername: "Please enter the Owner Name",
                    shopname: "Please enter the Shop Name",
                    shoplicensenumber: "Please enter the Shop License Number",
                    address: "Please enter the Address",
                    phonenumber: {
                        required: "Please enter your Phone Number",
                        lettersonly: "Only digits should be entered",
                        minlength: "Number of digits should be 10",
                        maxlength: "Number of digits should be 10"
                    },
                    city: "Please enter the City",
                    state: "Please enter the state",
                    country: "Please enter the Country",
                    email: "Please enter a valid email address",
                    username: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                    password: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                    confirmpassword: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long",
                        equalTo: "Please enter the same password as above"
                    },
                    agree: "Please accept our Privacy Policy and Terms & Conditions"
                },

                submitHandler: function(form) {
                    form.submit();
                }
            });
            $("#username").focus(function(){
                var firstname = $("#firstname").val();
                var lastname = $("#lastname").val();
                if(firstname && lastname && !this.value){
                    this.value = firstname + "." + lastname;
                }
            });