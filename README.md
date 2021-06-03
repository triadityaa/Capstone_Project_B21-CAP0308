# Capstone_Project_B21-CAP0308

## Chatbot
This chatbot is build using Rasa Open Source.

Steps to replicate:<br>
1. Make sure Python, Pip, Rasa, Transformers are installed
2. Init Rasa project using 'rasa init' command
3. Define intents and responses in domain.yml
4. Collect training data and store in data/nlu.yml
5. Define stories and rules in the data folder
6. Build pipeline in config.yml
7. Train model using 'rasa train' command
