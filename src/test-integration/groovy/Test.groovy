import org.springframework.beans.factory.annotation.Autowired
import pl.kaczmarek.pizzaplace.OrderRepository
import testapi.MockMvcSpec

import javax.sql.DataSource

class Test extends MockMvcSpec {

    @Autowired
    private DataSource dataSource

    @Autowired
    private OrderRepository orderRepository

    def 'test'() {

        given:
        when:
            def (response, json) = performGet("/test", new HashMap<String, Object>())
            def (response1, json1) = performGet("/test2", new HashMap<String, Object>())
        then:
            response.status == 200
            def all = orderRepository.findAll()
            print('dasda')
    }
}
