import tkinter as tk
from tkinter import ttk
from binary_to_decimal import bin_to_dec, dec_to_bin
from PIL import Image, ImageTk

def to_decimal():
    try:
        input_value = entry.get()
        output_text.config(text=f"Binary to Decimal: {input_value}")
    except ValueError:
        print("Value error thrown")
        output_text.config(text="Invalid Input")


def to_binary():
    try:
        input_value = entry.get()
        output_text.config(state=tk.NORMAL)  # Enable editing to change the text
        output_text.delete(1.0, tk.END)      # Clear previous text
        output_text.insert(tk.END, dec_to_bin(int(input_value)))  # Insert new text
        output_text.tag_configure("center", justify='center')  # Configure tag to center-align
        output_text.tag_add("center", "1.0", "end")
        output_text.config(state=tk.DISABLED)
    except ValueError:
        print("Value error thrown")
        output_text.config(state=tk.NORMAL)  # Enable editing to change the text
        output_text.delete(1.0, tk.END)      # Clear previous text
        output_text.insert(tk.END, "Invalid Input")  # Insert new text
        output_text.tag_configure("center", justify='center')  # Configure tag to center-align
        output_text.tag_add("center", "1.0", "end")
        output_text.config(state=tk.DISABLED)

root = tk.Tk()
root.geometry("300x300")
root.resizable(False, False)
root.title("Decimal to Binary")
bg_color = "#f0f0f0"  # Example background color
root.configure(bg=bg_color)
# root.iconbitmap("C:\\Users\\HP\\Documents\\Repos\\july_2024\\python\\applications\\bin2dec\\rebound.png")
icon_image = Image.open("C:\\Users\\HP\\Documents\\Repos\\july_2024\\python\\applications\\bin2dec\\rebound.png")  # Replace with the path to your .png file
photo = ImageTk.PhotoImage(icon_image)
root.iconphoto(False, photo)

entry = tk.Entry(root, font=("Arial", 14))
entry.pack(pady=10)

to_dec = tk.Button(root, text="To Dec(Unimplemented)", command=to_decimal, font=("Arial", 14))
to_dec.pack(pady=10)

to_bin = tk.Button(root, text="To Bin", command=to_binary, font=("Arial", 14))
to_bin.pack(pady=10)

output_text = tk.Text(root, font=("Arial", 14), height=1, width=20, wrap=tk.WORD, bg=bg_color, bd=0)
output_text.pack(pady=10)
output_text.insert(tk.END, "Output : ")
output_text.tag_configure("center", justify='center')  # Configure tag to center-align
output_text.tag_add("center", "1.0", "end")
output_text.config(state=tk.DISABLED)

root.mainloop()




# goals

# an input box to get the decimal and an output area to show the binary value
# arrange them neatly in the screen