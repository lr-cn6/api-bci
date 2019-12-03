package cl.globallogic.recruiting.apibci.service;

import cl.globallogic.recruiting.apibci.model.User;

import java.util.UUID;

/**
 * @author Luis Riveros - luis.riveros_ex@scotiabank.cl
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
public interface UserService {

    public User getPeopleRs(UUID id);

    public Boolean addPeople(User p);
}
