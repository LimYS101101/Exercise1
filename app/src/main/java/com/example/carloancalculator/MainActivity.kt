package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            val carPrice:Double = editTextCarPrice.text.toString().toDouble()
            val loanPeriod:Double = editTextLoanPeriod.text.toString().toDouble()
            val downPayment:Double = editTextDownPayment.text.toString().toDouble()
            val interestRate:Double = editTextInterestRate.text.toString().toDouble()

            val loan:Double = carPrice - downPayment
            val interest:Double = loan * (interestRate/100) * loanPeriod
            val monthlyRepayment:Double = (loan + interest) / loanPeriod / 12

            textViewLoan.text = "Loan: RM %.2f".format(loan)
            textViewInterest.text = "Interest: RM %.2f".format(interest)
            textViewMonthlyRepayment.text = "Monthly Repayment: RM %.2f".format(monthlyRepayment)

        }

        buttonReset.setOnClickListener {
            editTextCarPrice.text = null
            editTextDownPayment.text = null
            editTextLoanPeriod.text = null
            editTextInterestRate.text = null

            textViewLoan.text = "Loan: "
            textViewInterest.text = "Interest: "
            textViewMonthlyRepayment.text = "Monthly Repayment: "
        }
    }
}
