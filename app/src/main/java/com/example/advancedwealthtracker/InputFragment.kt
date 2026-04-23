package com.example.advancedwealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.advancedwealthtracker.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lgliBtnSave.setOnClickListener {
            val incomeStr = binding.lgliEtIncome.text.toString()
            val expensesStr = binding.lgliEtExpenses.text.toString()

            // ვალიდაცია (setError)
            if (incomeStr.isEmpty()) {
                binding.lgliEtIncome.error = "შეიყვანეთ შემოსავალი"
                return@setOnClickListener
            }
            if (expensesStr.isEmpty()) {
                binding.lgliEtExpenses.error = "შეიყვანეთ ხარჯები"
                return@setOnClickListener
            }

            val income = incomeStr.toDouble()
            val expenses = expensesStr.toDouble()

            // მონაცემების გაგზავნა Fragment Result API-ით
            parentFragmentManager.setFragmentResult("wealth_request_key", bundleOf(
                "income" to income,
                "expenses" to expenses
            ))


            binding.lgliEtIncome.text.clear()
            binding.lgliEtExpenses.text.clear()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}