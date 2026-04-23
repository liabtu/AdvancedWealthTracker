package com.example.advancedwealthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.advancedwealthtracker.databinding.FragmentAnalyticsBinding

class AnalyticsFragment : Fragment() {

    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!

    // WealthManager-ის ინსტანცია გამოთვლებისთვის
    private val wealthManager = WealthManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalyticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // მონაცემების "მოსმენა"
        parentFragmentManager.setFragmentResultListener("wealth_request_key", viewLifecycleOwner) { _, bundle ->
            val income = bundle.getDouble("income")
            val expenses = bundle.getDouble("expenses")

            // გამოთვლა WealthManager კლასის გამოყენებით
            val finalSavings = wealthManager.calculateFinalSavings(income, expenses)

            // შედეგის გამოტანა
            binding.lgliTvResult.text = "შენი დანაზოგი (K=0.5): $finalSavings"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}