# py_calc.py

import tkinter as tk

# Create the main application window
root = tk.Tk()
root.title("Modern Calculator")
root.geometry("400x600")

# Styling
root.configure(bg="#2c2c2c")

# Display frame
display_frame = tk.Frame(root, height=100, bg="#2c2c2c")
display_frame.pack(expand=True, fill='both')

# Display label
display_label = tk.Label(display_frame, text="", anchor="e", bg="#2c2c2c", fg="white", padx=24, font=("Arial", 40))
display_label.pack(expand=True, fill='both')

# Buttons frame
buttons_frame = tk.Frame(root, bg="#2c2c2c")
buttons_frame.pack(expand=True, fill='both')

# Button texts
button_texts = [
    '7', '8', '9', '/',
    '4', '5', '6', '*',
    '1', '2', '3', '-',
    'C', '0', '=', '+'
]

# Button creation
buttons = []
for text in button_texts:
    button = tk.Button(buttons_frame, text=text, font=("Arial", 24), fg="white", bg="#4d4d4d", bd=0, highlightthickness=0)
    buttons.append(button)

# Button layout
row_value = 0
column_value = 0
for button in buttons:
    button.grid(row=row_value, column=column_value, sticky='nsew')
    column_value += 1
    if column_value == 4:
        column_value = 0
        row_value += 1

# Grid configuration
for i in range(4):
    buttons_frame.grid_columnconfigure(i, weight=1)
    buttons_frame.grid_rowconfigure(i, weight=1)

# Button functionalities
def on_button_click(event):
    current_text = display_label.cget("text")
    new_text = current_text + event.widget.cget("text")
    
    if event.widget.cget("text") == "C":
        new_text = ""
    elif event.widget.cget("text") == "=":
        try:
            new_text = str(eval(current_text))
        except:
            new_text = "Error"
    
    display_label.config(text=new_text)

# Binding buttons
for button in buttons:
    button.bind("<Button-1>", on_button_click)

# Start the application
root.mainloop()


