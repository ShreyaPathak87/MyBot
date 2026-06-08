package com.example.mybot;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout chatLayout;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.userInput);
        Button send = findViewById(R.id.sendBtn);
        chatLayout = findViewById(R.id.chatLayout);
        scrollView = findViewById(R.id.scrollView);

        send.setOnClickListener(v -> {
            String userText = input.getText().toString().trim();

            if (userText.isEmpty()) return;

            addMessage(userText, true);

            String msg = userText.toLowerCase();
            String botReply;

            // 👋 Greetings
            if (msg.contains("hello") || msg.contains("hi") || msg.contains("hey")) {
                botReply = "Hey! 😊 How can I help you today?";
            }
            else if (msg.contains("good morning")) {
                botReply = "Good morning! ☀️ Have a great day!";
            }
            else if (msg.contains("good evening")) {
                botReply = "Good evening! 🌆 How was your day?";
            }

            // 🤖 About bot
            else if (msg.contains("your name")) {
                botReply = "I'm your personal AI assistant 🤖";
            }
            else if (msg.contains("who made you") || msg.contains("who created you")) {
                botReply = "I was created by a smart developer like you 😄";
            }
            else if (msg.contains("what can you do")) {
                botReply = "I can chat with you, answer questions, and help with studies 💡";
            }

            // 😊 Feelings
            else if (msg.contains("how are you")) {
                botReply = "I'm doing great! 😄 What about you?";
            }
            else if (msg.contains("i am sad") || msg.contains("sad")) {
                botReply = "Oh no 😔 I'm here for you. Want to talk?";
            }
            else if (msg.contains("i am good") || msg.contains("good")) {
                botReply = "Oh WOw! 😄 That's nice";
            }
            else if (msg.contains("i am nice") || msg.contains("nice")) {
                botReply = "Oh WOw! 😄 That's nice";
            }
            else if (msg.contains("good") || msg.contains("nice")) {
                botReply = "Thanks😄";
            }
            else if (msg.contains("what's up") || msg.contains("whats up")) {
                botReply = "All good here 😄 What about you?";
            }

            // 😂 Fun
            else if (msg.contains("joke")) {
                botReply = "Why do programmers hate nature? 😂 Because it has too many bugs 🐛";
            }
            else if (msg.contains("fact")) {
                botReply = "Did you know? 🤔 The brain uses 20% of body energy!";
            }

            // 📚 Study / Tech
            else if (msg.contains("what is ai")) {
                botReply = "AI is Artificial Intelligence 🤖";
            }
            else if (msg.contains("java")) {
                botReply = "Java is used for Android apps 💻";
            }
            else if (msg.contains("android studio")) {
                botReply = "It is used to build Android apps 📱";
            }
            else if (msg.contains("api")) {
                botReply = "API lets apps communicate 🌐";
            }

            // 🌍 GK
            else if (msg.contains("prime minister")) {
                botReply = "PM of India is Narendra Modi 🇮🇳";
            }
            else if (msg.contains("capital of india")) {
                botReply = "New Delhi 🏙️";
            }

            // 💡 Help
            else if (msg.contains("help")) {
                botReply = "Ask me anything 😊";
            }
            else if (msg.contains("motivate")) {
                botReply = "Believe in yourself 💪";
            }

            // 👋 Ending
            else if (msg.contains("bye")) {
                botReply = "Goodbye 👋 Have a great day!";
            }
            else if (msg.contains("thank")) {
                botReply = "You're welcome 😊";
            }

            // 🤔 Default
            else {
                botReply = "Hmm 🤔 I'm still learning!";
            }

            // ⏳ Typing effect
            addMessage("Typing...", false);

            new Handler().postDelayed(() -> {
                chatLayout.removeViewAt(chatLayout.getChildCount() - 1);
                addMessage(botReply, false);
            }, 1000);

            input.setText("");
        });
    }

    // 💬 Add message bubble
    private void addMessage(String message, boolean isUser) {
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(16);
        textView.setPadding(20, 12, 20, 12);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        if (isUser) {
            textView.setBackgroundResource(R.drawable.user_bg);
            textView.setTextColor(0xFF000000);
            params.setMargins(120, 10, 10, 10);
        } else {
            textView.setBackgroundResource(R.drawable.bot_bg);
            textView.setTextColor(0xFF000000);
            params.setMargins(10, 10, 120, 10);
        }

        textView.setLayoutParams(params);
        chatLayout.addView(textView);

        // 🔽 Auto scroll
        scrollView.postDelayed(() ->
                scrollView.fullScroll(ScrollView.FOCUS_DOWN), 50);
    }
}