import tkinter as tk

def Add_Task():
    task=task_ip.get()
    if task:
        task_list.insert(tk.END,task)
        task_ip.delete(0,tk.END)

def Remove_Task():
    task=task_list.curselection()
    if task:
        task_list.delete(task)




app=tk.Tk()
app.title("TO DO LIST :)")

#Input of task
task_ip=tk.Entry(app,width=50)
task_ip.pack(pady=10)

#Add task
add_B=tk.Button(app,text="Add task to list",command=Add_Task)
add_B.pack()

#To display Task
task_list=tk.Listbox(app,selectmode=tk.SINGLE,width=30)
task_list.pack()


#to Remove Task

remove_B=tk.Button(app,text="Remove task from list",command=Remove_Task)
remove_B.pack()

app.mainloop()
