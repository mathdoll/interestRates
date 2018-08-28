package pkg;

import com.sun.tools.javac.comp.Todo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class LoanServiceTest {

    @InjectMocks
    private LoanService loanService;

    @Mock
    private UserService userService;

    @Mock
    private CreditScoreServiceEquifax creditScoreServiceEquifax;

    @Mock
    private CreditScoreServiceExperian creditScoreServiceExperian;

    @Mock
    private MissedPaymentService missedPaymentService;

    @Before
    public void setUp(){
        loanService = new LoanService();
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void loanFor850Fico()throws Exception{

        when(userService.getSSN(anyString())).thenReturn("123456789");

        when(creditScoreServiceEquifax.getFico(anyString())).thenReturn(850);

        when(creditScoreServiceExperian.getFico(anyString())).thenReturn(850);

        when(missedPaymentService.missedPayment(6)).thenReturn(3);

        when(missedPaymentService.missedPayment(12)).thenReturn(0);

        when(missedPaymentService.missedPayment(24)).thenReturn(0);

        Assert.assertEquals(7,loanService.getInterestRate("user1",24));

    }

    @Test
    public void loanFor775Fico()throws Exception{

        when(userService.getSSN(anyString())).thenReturn("123456789");

        when(creditScoreServiceEquifax.getFico(anyString())).thenReturn(775);

        when(creditScoreServiceExperian.getFico(anyString())).thenReturn(775);

        //TODO: find return values (calculate)
        when(missedPaymentService.missedPayment(6)).thenReturn(3);

        when(missedPaymentService.missedPayment(12)).thenReturn(0);

        when(missedPaymentService.missedPayment(24)).thenReturn(0);

        Assert.assertEquals(8,loanService.getInterestRate("user1",24));

    }

    @Test
    public void loanFor700Fico()throws Exception{

        when(userService.getSSN(anyString())).thenReturn("123456789");

        when(creditScoreServiceEquifax.getFico(anyString())).thenReturn(700);

        when(creditScoreServiceExperian.getFico(anyString())).thenReturn(700);

        //TODO: find return values (calculate)
        when(missedPaymentService.missedPayment(6)).thenReturn(3);

        when(missedPaymentService.missedPayment(12)).thenReturn(0);

        when(missedPaymentService.missedPayment(24)).thenReturn(0);

        Assert.assertEquals(9,loanService.getInterestRate("user1",24));

    }

    @Test
    public void loanFor625Fico()throws Exception{

        when(userService.getSSN(anyString())).thenReturn("123456789");

        when(creditScoreServiceEquifax.getFico(anyString())).thenReturn(625);

        when(creditScoreServiceExperian.getFico(anyString())).thenReturn(625);

        //TODO: find return values (calculate)
        when(missedPaymentService.missedPayment(6)).thenReturn(3);

        when(missedPaymentService.missedPayment(12)).thenReturn(0);

        when(missedPaymentService.missedPayment(24)).thenReturn(0);

        Assert.assertEquals(10,loanService.getInterestRate("user1",24));

    }

}
