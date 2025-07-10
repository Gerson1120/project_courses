package utez.edu.mx.melimas.user.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import utez.edu.mx.melimas.user.model.UserEntity;
import utez.edu.mx.melimas.user.model.UserReopository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserReopository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserReopository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        logger.info("Obteniendo lista de usuarios");
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        logger.info("Buscando usuario con ID: {}", id);
        return userRepository.findById(id);
    }

    public UserEntity createUser(UserEntity user) {
        logger.info("Creando usuario con email: {}", user.getEmail());
        try {
            UserEntity savedUser = userRepository.save(user);
            logger.info("Usuario creado con ID: {}", savedUser.getUser_id());
            return savedUser;
        } catch (Exception e) {
            logger.error("Error al crear usuario: {}", e.getMessage());
            throw e;
        }
    }

    public UserEntity updateUser(Long id, UserEntity userDetails) {
        logger.info("Actualizando usuario con ID: {}", id);
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setLastName(userDetails.getLastName());
            user.setSurname(userDetails.getSurname());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setStatusActive(userDetails.getStatusActive());
            user.setRoles(userDetails.getRol());
            UserEntity updatedUser = userRepository.save(user);
            logger.info("Usuario actualizado con ID: {}", updatedUser.getUser_id());
            return updatedUser;
        }).orElseThrow(() -> {
            logger.error("Usuario no encontrado con ID: {}", id);
            return new RuntimeException("Usuario no encontrado");
        });
    }

    public void deleteUser(Long id) {
        logger.info("Eliminando usuario con ID: {}", id);
        try {
            userRepository.deleteById(id);
            logger.info("Usuario eliminado con ID: {}", id);
        } catch (Exception e) {
            logger.error("Error al eliminar usuario: {}", e.getMessage());
            throw e;
        }
    }
}
