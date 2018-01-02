package com.nfc.portal.serviceImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nfc.portal.entity.Permission;
import com.nfc.portal.entity.Role;
import com.nfc.portal.repository.UserRepository;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;


	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String email)
			throws UsernameNotFoundException {

		com.nfc.portal.entity.User user = userRepository.findByEmail(email.toLowerCase());
		
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(com.nfc.portal.entity.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(), user.getEnabled(),
				true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<Role> roles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Role role : roles) {

			for (Permission permission : role.getPermissions()) {
				setAuths.add(new SimpleGrantedAuthority(permission.getName()));
				System.out.println("XDD " + permission.getName());
			}

		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);

		return Result;
	}

}