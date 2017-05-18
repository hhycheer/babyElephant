/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: #
 * 
 */
function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('注册');
    }); 
    $('.error').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');    
        });
        
        $('.modal-title').html('登陆');
    });       
     $('.error').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');
    }, 230);
    
}

function loginAjax(){
    var data={'userName':$("#email").val(),'password':$("#password").val()}
    $.ajax({
        type: "POST",
        url: "/user/login",
        data: data,
        success: function(msg){
            if (msg=="ERROR"){
                shakeModal();
            }else{
                $('#loginModal').modal('hide');
                location.reload();
            }
        }
    });
}


function saveAjax() {

    var data={'userName':$("#email1").val(),'password':$("#password1").val(),'password_confirmation':$("#password_confirmation").val()}
    $.ajax({
        type: "POST",
        url: "/user/save",
        data: data,
        success: function(msg){
            if (msg=="ERROR"){
                shakeModal();
            }else{
                alert("注册成功");
                $('#loginModal').modal('hide');
            }
        }
    });
}

function checkout() {
    $.ajax({
        type: "POST",
        url: "/user/checkout",
        success: function(){
            location.reload();
        }
    });
}

function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.error').addClass('alert alert-danger').html("Invalid email/password combination");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}

   