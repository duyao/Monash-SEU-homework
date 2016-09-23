/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import javax.ejb.Remote;

/**
 *
 * @author dy
 */
@Remote
public interface GroupRepository {
    public void addGroup(String type, String username);
}
