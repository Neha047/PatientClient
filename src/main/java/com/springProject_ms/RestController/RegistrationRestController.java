package com.springProject_ms.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springProject_ms.Model.Registration;
import com.springProject_ms.Repo.Registration_repo;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationRestController {
	
	@Autowired
	public RestTemplate restTemp;
	
    @Autowired
	private Registration_repo regrep;
//	@Autowired
//	private Login_repo logrep;
List<Registration> list1=new ArrayList<>();
	Registration regi;
	
	
	
	
	@PostMapping("/registration")
	public Boolean addPatient(@RequestBody Registration regist) {
		 if(!regrep.existsByUsername(regist.getUsername())&& !regrep.existsByEmail(regist.getUsername())){
			 if(!regist.getName().equals("") && !regist.getEmail().equals("")&& ! regist.getPassword().equals("") && regist.getContact()!=0) {
			 regrep.save(regist);
			 return true;
		 }
		 }
		 return false;
	        //    return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);}
//		 if(regrep.existsByEmail(regist.getUsername())){
//	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);}
//		 
//		  regrep.save(regist);
//		 return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	}




	
	
	@GetMapping("registration")
	public List<Registration> getAll(){
		return regrep.findAll();
	}
	
	@GetMapping("allappoint")
public List<Object> getPatient(){
	Object[] all=restTemp.getForObject("http://appointment-ms/allappoint", Object[].class);
	return Arrays.asList(all);
	
}
	

//	 @PostMapping("registration/loginss")
//	    public String authenticateUser(@RequestBody String user,String pass){
//		 
//		 Registration regi=logrep.findByUsername(user);
//		 System.out.println(regi.getPassword());
//		 System.out.println(regi.getUsername());
//		 if(user.endsWith(regi.getUsername())) {
//			 System.out.println("yup");
//			 return "";
//			 }else {
//				 System.out.println("not");
//				 return null;
//			 
//		 }
//			 
//   }
//	 @PostMapping("/logins")
//		public ResponseEntity<String> loginUser(@RequestBody Registration regi) {
//			String username= regi.getUsername();
////			System.out.println(regrep.getByUsername(username));
////			System.err.println(regrep.getByUsername(username));
//			Registration redata=regrep.getByUsername(username);
//			if(regi.getUsername().equals(redata) && regi.getPassword().equals(redata.getPassword()) )
//				 return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//			 return new ResponseEntity<>("Sorry", HttpStatus.BAD_REQUEST);
//
//			
//		}
//		List<Registration> list =new ArrayList<>();
//		public Registration getSingle(String username) {
//		
//			return this.list1.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
//		}
//	
	
	@PostMapping("registration/login")
	public boolean login(@RequestBody Registration regi) {
//		int uid=regi.getId();
		String username=regi.getUsername();
	//	String username=regi.getUsername();
		System.out.println();
		Registration redata=regrep.findByUsername(username);
//		Optional<Registration> redata=logrep.findById(uid);
		
	//	boolean exist=logrep.existsById(uid);
		System.out.println(regi.getPassword());
//		System.out.println(redata.get().getPassword());
//		System.out.println(redata.get().getUsername());
		//if(!exist) {
		//	System.out.println("not");
			//return false;
		//}
		//else {
			//&&(regi.getUsername().equals(redata.get().getUsername()))
		if(regi.getPassword().equals(redata.getPassword())) {
			System.out.println("yup");
		return true;
		}else {
			System.out.println("not");
			return false;
		}
	//	}
			
	}

}
