import org.moita.sb2.service.SimpleEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleEmployeeServiceFixture {

    @Autowired
    private SimpleEmployeeService employeeService;
//
//    public SimpleEmployeeServiceFixture() {
//        FixtureWirer.wire(this);
//    }
//
//    public Collection<Employee> listEmployees() {
//        return employeeService.listEmployees();
//    }
}
