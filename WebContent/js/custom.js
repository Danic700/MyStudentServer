(function ($) {
	$( '#dl-menu' ).dlmenu();
	$('ul.dl-menu li a').smoothScroll();


	//animation
	new WOW().init();

})(jQuery);

//alert("aaa");
function findByID()
{
	alert("Searching for student");
	var location = window.location.href;
	
    var id = document.getElementById("id").value;
    var url = 'StudentServlet?id='+id+'';
    
if(id)
window.location = location.concat(url);
else
alert("you must enterID");
		
}

function AddStudent()
{
	alert("Adding student");
    var id = document.getElementById("id").value;
    var fullName = document.getElementById("fullName").value;
    var gender = document.getElementById("gender").value;
    var gpa = document.getElementById("gpa").value;
    var url = 'StudentServlet/add?id='+id+'&name='+fullName+'&gender='+gender+'&grade='+gpa+'';
    var location = window.location.href;	

if(id)
window.location = location.concat(url);

else
alert("you must enter ID");
		
}

function RemoveStudent()
{
	alert("Removing student");
    var location = window.location.href;
	
    var id = document.getElementById("id").value;
    var url = 'StudentServlet/remove?id='+id+'';
    
if(id)
window.location = location.concat(url);
else
alert("you must enter ID");
		
}