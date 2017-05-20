
package com.example.DAOImpl;

import com.example.DAOService.DepartmentDAO;
import com.example.data.Department;
import com.example.repository.DepartmentRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDAOServiceImpl implements DepartmentDAO{
    
    @Resource
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Department insert(Department c) {
        Department dep = new Department();
        if(c == null)
        {
            
        }
        else{
        
        dep.setDepartmentName(c.getDepartmentName());
        dep.setDepartmentType(c.getDepartmentType());
        
        }
        return departmentRepository.save(dep);
        
    }

    public Department getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Department delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Department update(Department c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Department getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
