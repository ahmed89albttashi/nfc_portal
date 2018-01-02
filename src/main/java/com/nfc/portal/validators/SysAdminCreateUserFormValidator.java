package com.nfc.portal.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nfc.portal.entity.Staff;
import com.nfc.portal.entity.User;
import com.nfc.portal.service.StaffService;
import com.nfc.portal.service.UserService;

@Component
public class SysAdminCreateUserFormValidator implements Validator{


	@Autowired
	UserService userService;

	@Autowired
	StaffService staffService;
	
	@Override
	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		
		
		User exUser = userService.getUserByEmail(user.getEmail());
		
		if(exUser != null ){
			System.out.println("XDD rejecting " +user.getEmail());
				
			errors.rejectValue("email","sys.admin.cuv.email.duplicate");
		}
		
		if(user.getStaff().getStaff_id()== null){

			errors.rejectValue("staff.staff_id","sys.admin.cuv.input.required");
		}else{
		 

			Staff staff= staffService.getStaffById(user.getStaff().getStaff_id());
			System.out.println("staff _ID "+user.getStaff().getStaff_id());
			if(staff != null){
				errors.rejectValue("staff.staff_id","sys.admin.cuv.staff_id.duplicate");

			}

			
		}
				
		
	}

}
