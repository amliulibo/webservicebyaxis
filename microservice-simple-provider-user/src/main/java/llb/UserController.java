package llb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable long id) {
		User findoneUser=userRepository.getOne(id);
		//userRepository.findOne(id);
		return findoneUser;
	}

}
