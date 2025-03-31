package org.example.todo.controller;

import org.example.todo.model.*;
import org.example.todo.repository.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class IndexController {

    InvestmentRepository investmentRepository;
    BudgetNotesRepository budgetNotesRepository;
    ExpenseFixedRepository expenseFixedRepository;
    ExpenseIntermittentRepository expenseIntermittentRepository;
    ExpenseMemoRepository expenseMemoRepository;
    ExpenseOtherRepository expenseOtherRepository;
    IncomeOtherRepository incomeOtherRepository;
    IncomeRegularRepository incomeRegularRepository;

    public IndexController(InvestmentRepository investmentRepository, BudgetNotesRepository budgetNotesRepository,
            ExpenseFixedRepository expenseFixedRepository, ExpenseIntermittentRepository expenseIntermittentRepository,
            ExpenseMemoRepository expenseMemoRepository, ExpenseOtherRepository expenseOtherRepository,
            IncomeOtherRepository incomeOtherRepository, IncomeRegularRepository incomeRegularRepository) {
        this.investmentRepository = investmentRepository;
        this.budgetNotesRepository = budgetNotesRepository;
        this.expenseFixedRepository = expenseFixedRepository;
        this.expenseIntermittentRepository = expenseIntermittentRepository;
        this.expenseMemoRepository = expenseMemoRepository;
        this.expenseOtherRepository = expenseOtherRepository;
        this.incomeOtherRepository = incomeOtherRepository;
        this.incomeRegularRepository = incomeRegularRepository;
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/investments")
    public String getInvestments(Model model){
        List<Investments> investments = investmentRepository.findAll();
        model.addAttribute("investments", investments);
        return "investment";
        }

    @GetMapping("/budget-planning")
    public String getBudgetPlan(Model model){
        List<BudgetNotes> budgetNotes = budgetNotesRepository.findAll();
        model.addAttribute("budgetNotes", budgetNotes);
        return "budget-Notes";
    }

    @GetMapping("/budget-modify")
    public String getBudgetMods(){
        return "budgetAddDelete";
    }

    @PostMapping("/budget-modify")
    public String getBudgetAdd(@RequestParam("futureExpense") String futureExpense,
                               @RequestParam("futureCost") int futureCost) {
        if (futureExpense == null || futureExpense.isEmpty() || futureCost < 0) {
            return "budgetAddDelete";
        }

        BudgetNotes budgetNotes2 = new BudgetNotes(futureExpense, futureCost);
        budgetNotesRepository.save(budgetNotes2);
        return "redirect:/";
    }

    @GetMapping("/budget-modify/{id}")
    public String getBudgetDelete(@PathVariable Long id) {
        budgetNotesRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/income-expenses")
    public String getIncomeExpenses(Model model){

        //2 income
        List<IncomeRegular> incomeRegulars = incomeRegularRepository.findAll();
        model.addAttribute("incomeRegulars", incomeRegulars);

        List<IncomeOther> incomeOthers = incomeOtherRepository.findAll();
        model.addAttribute("incomeOthers", incomeOthers);

        //3 expenses
        List<ExpenseOther> expenseOthers = expenseOtherRepository.findAll();
        model.addAttribute("expenseOthers", expenseOthers);

        List<ExpenseFixed> expenseFixed = expenseFixedRepository.findAll();
        model.addAttribute("expenseFixed", expenseFixed);

        List<ExpenseIntermittent> expenseIntermittent = expenseIntermittentRepository.findAll();
        model.addAttribute("expenseIntermittent", expenseIntermittent);

        return "income-Expenses";
    }

    @GetMapping("/income-expenses-mod")
    public String getIncomeExpensesMod(){
        return "income-Expenses-Mod";
    }

    @GetMapping("/fixed-income")
    public String fixedIncome(){
        return "fixedIncome";
    }

    @PostMapping("/fixed-income")
    public String addFixedIncome(@RequestParam("date") String date,
                                 @RequestParam("income") int income,
                                 @RequestParam("info") String info) {

        if (income <= 0 || info == null || info.isEmpty()) {
            return "fixedIncome";
        }

        try {
            IncomeRegular incomeRegular = new IncomeRegular(date, income, info);
            incomeRegularRepository.save(incomeRegular);
        } catch (Exception e) {
            return "fixedIncome";
        }

        return "redirect:/";  // Redirect to homepage on success
    }

    @GetMapping("/fixed-income/{id}")
    public String deleteFixedIncome(@PathVariable Long id) {
        incomeRegularRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/other-income")
    public String otherIncome(){
        return "otherIncome";
    }

    @PostMapping("/other-income")
    public String addOtherIncome(@RequestParam("date") String date,
                                 @RequestParam("income") int income,
                                 @RequestParam("info") String info) {

        if (income <= 0 || info == null || info.isEmpty()) {
            return "otherIncome";
        }

        try {
            IncomeOther incomeOther = new IncomeOther(date, income, info);
            incomeOtherRepository.save(incomeOther);
        } catch (Exception e) {
            return "otherIncome";
        }

        return "redirect:/";  // Redirect to homepage on success
    }

    @GetMapping("/other-income/{id}")
    public String getOtherIncomeDelete(@PathVariable Long id) {
        incomeOtherRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/fixed-expense")
    public String fixedExpenses(){
        return "fixedExpense";
    }

    @PostMapping("/fixed-expense")
    public String deletedFixedExpense(@RequestParam("expense") int expense,
                                 @RequestParam("note") String note) {

        if (expense <= 0 || note == null || note.isEmpty()) {
            return "fixedExpense";
        }

        try {
            ExpenseFixed expenseFixed = new ExpenseFixed(expense, note);
            expenseFixedRepository.save(expenseFixed);
        } catch (Exception e) {
            return "fixedExpense";
        }

        return "redirect:/";  // Redirect to homepage on success
    }

    @GetMapping("/fixed-expense/{id}")
    public String fixedExpenseDelete(@PathVariable Long id) {
        expenseFixedRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/intermittent-expense")
    public String intermittentExpenses(){
        return "intermittentExpense";
    }

    @PostMapping("/intermittent-expense")
    public String deletedIntermittentExpense(@RequestParam("expense") int expense,
                                      @RequestParam("note") String note) {

        if (expense <= 0 || note == null || note.isEmpty()) {
            return "intermittentExpense";
        }

        try {
            ExpenseIntermittent expenseIntermittent = new ExpenseIntermittent(expense, note);
            expenseIntermittentRepository.save(expenseIntermittent);
        } catch (Exception e) {
            return "intermittentExpense";
        }

        return "redirect:/";  // Redirect to homepage on success
    }

    @GetMapping("/intermittent-expense/{id}")
    public String getInterDelete(@PathVariable Long id) {
        expenseIntermittentRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/other-expense")
    public String otherExpenses(){
        return "otherExpense";
    }

    @PostMapping("/other-expense")
    public String deletedOtherExpense(@RequestParam("expense") int expense,
                                             @RequestParam("note") String note) {

        if (expense <= 0 || note == null || note.isEmpty()) {
            return "otherExpense";
        }

        try {
            ExpenseOther expenseOther = new ExpenseOther(expense, note);
            expenseOtherRepository.save(expenseOther);
        } catch (Exception e) {
            return "otherExpense";
        }

        return "redirect:/";  // Redirect to homepage on success
    }

    @GetMapping("/other-expense/{id}")
    public String getOtherDelete(@PathVariable Long id) {
        expenseOtherRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/etransfers")
    public String getEtransfers(Model model){
        List<ExpenseMemo> expenseMemos = expenseMemoRepository.findAll();
        model.addAttribute("expenseMemos", expenseMemos);
        return "etransfer";
    }

    @GetMapping("/etransfers-Mod")
    public String getEtransfersMod(Model model){
        return "etransfer-mod";
    }

    @PostMapping("/etransfers-Mod")
    public String getEtransfersAdd(@RequestParam("email") String email,
                                   @RequestParam("amount") int amount,
                                   @RequestParam("memoLine") String memoLine) {

        if (email == null || email.isEmpty() || amount <= 0 || memoLine == null || memoLine.isEmpty()) {
            return "etransfer-mod";
        }

        try {
            ExpenseMemo expenseMemo = new ExpenseMemo(email, amount, memoLine);
            expenseMemoRepository.save(expenseMemo);
        } catch (Exception e) {
            return "etransfer-mod";
        }

        return "redirect:/";  // Redirect to homepage if success
    }

    @GetMapping("/etransfers-Mod/{id}")
    public String getEtransferDelete(@PathVariable Long id) {
        expenseMemoRepository.deleteById(id);
        return "redirect:/";
    }
}
