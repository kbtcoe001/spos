import tkinter as tk
from tkinter import messagebox

def register():
    username = username_entry.get()
    password = password_entry.get()
    confirm_password = confirm_password_entry.get()

    if not (username and password and confirm_password):
        messagebox.showerror("Error", "Please fill in all fields.")
    elif password != confirm_password:
        messagebox.showerror("Error", "Passwords do not match.")
    else:
        messagebox.showinfo("Success", "Registration successful for " + username)
        # You can add code here to save the registration data to a file or database.

# Create the main window
root = tk.Tk()
root.title("Registration Form")

# Create and layout form components
username_label = tk.Label(root, text="Username:")
username_label.pack()
username_entry = tk.Entry(root)
username_entry.pack()

password_label = tk.Label(root, text="Password:")
password_label.pack()
password_entry = tk.Entry(root, show="*")  # Use "show" to hide the password characters
password_entry.pack()

confirm_password_label = tk.Label(root, text="Confirm Password:")
confirm_password_label.pack()
confirm_password_entry = tk.Entry(root, show="*")
confirm_password_entry.pack()

register_button = tk.Button(root, text="Register", command=register)
register_button.pack()

# Start the main loop
root.mainloop()
