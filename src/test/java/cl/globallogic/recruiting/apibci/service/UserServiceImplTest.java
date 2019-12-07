package cl.globallogic.recruiting.apibci.service;


import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl service;

    @Before
    public void setUp() {
        User u = new User();
        u.setId(UUID.randomUUID().toString());
        u.setActive(true);
        u.setCreated(LocalDateTime.now());
        u.setName("admin");
        u.setPassword("Admin12");
        u.setEmail("admin@bci.cl");

        Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(u));
        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(u)
                .thenThrow(new IllegalArgumentException());
    }

    @Test
    public void getUserRs() {
        Assert.notNull(service.getUserRs("id"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addUser() throws Exception {
        User u = new User();

        Assert.notNull(service.addUser(u));
        Assert.notNull(service.addUser(u));
    }
}