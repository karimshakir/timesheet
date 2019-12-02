document.getElementById("userSignInId").addEventListener("click", function(e) {
  e.preventDefault(e); 
  user = {
    userName: document.getElementById("userName").value,
    password: document.getElementById("password").value,
  };

	  let promise = axios.post("http://localhost:8080/timesheet/api/user", user); 
	
	  promise.then(function(response) {
	  
	    currentUser = response.data;
	    
	    let getPromise = axios.get('http://localhost:8080/timesheet/api/timesheets?userId=' + currentUser.userId);
	
	    getPromise.then(function(response){
	        
	        response.log;
        
    });
 
    	getPromise.catch(function(response){
  
    }) ; 

    	console.log(currentUser.userId)
    
	});
	promise.catch(function(response){
	    console.log(response);
	  
	
	}); 

}); 
