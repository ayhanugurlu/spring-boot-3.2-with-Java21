package com.au.example.springboot32withjava21.sealed;

public class SealedExample {

    String displayUserForLoanSwitch(Loan loan) {
        return switch (loan) {
            case SecuredLoan sl -> "Secured Loan";
            case UnSecuredLoan usl -> "UnSecured Loan " + usl.interest();
        };

    }

    String displayUserForLoanWithIf(Loan loan) {

        if (loan instanceof SecuredLoan sl) {
            System.out.println(sl.getClass());
            return "Secured Loan";
        } else if (loan instanceof UnSecuredLoan usl) {
            System.out.println(usl.interest());
            return "UnSecured Loan";
        } else {
            return "Unknown Loan";
        }
    }
}


sealed interface Loan permits SecuredLoan, UnSecuredLoan {

}


final class SecuredLoan implements Loan {

}


record UnSecuredLoan(float interest) implements Loan {

}
