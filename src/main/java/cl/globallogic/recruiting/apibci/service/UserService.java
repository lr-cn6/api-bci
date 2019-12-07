package cl.globallogic.recruiting.apibci.service;

import cl.globallogic.recruiting.apibci.exception.ApiBciException;
import cl.globallogic.recruiting.apibci.model.User;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
public interface UserService {

    public User getUserRs(String id) throws ApiBciException;

    public User addUser(User p) throws ApiBciException;
}
