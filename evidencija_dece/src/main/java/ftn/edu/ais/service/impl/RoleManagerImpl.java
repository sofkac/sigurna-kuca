package ftn.edu.ais.service.impl;

import java.util.List;

import ftn.edu.ais.dao.RoleDao;
import ftn.edu.ais.model.Role;
import ftn.edu.ais.service.RoleManager;

/**
 * Implementation of RoleManager interface.
 * 
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
public class RoleManagerImpl extends UniversalManagerImpl implements RoleManager {
    private RoleDao dao;

    public void setRoleDao(RoleDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    public List<Role> getRoles(Role role) {
        return dao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    public Role getRole(String rolename) {
        return dao.getRoleByName(rolename);
    }

    /**
     * {@inheritDoc}
     */
    public Role saveRole(Role role) {
        return dao.save(role);
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
        dao.removeRole(rolename);
    }
}