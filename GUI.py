# sudo apt install pyhton3-tk    (Terminal Command)

from tkinter import *
   
window=Tk()
window.background="blue"
window.title('Employee Information')
window.configure(bg='mintcream')

label13 = Label(text="Personal",foreground="orange",background="mintcream" ,width=15,height=2)
label13.place(x=390, y=15)

label14 = Label(text="Job",foreground="orange",background="mintcream" ,width=15,height=2)
label14.place(x=730, y=15)

label1 = Label(text="Name",foreground="black",background="mintcream" ,width=15,height=2)
label1.place(x=320, y=70)

txtfld1=Entry(text="no1", bd=5)
txtfld1.place(x=420, y=70)


label2 = Label(text="Designation",foreground="black",background="mintcream" ,width=15,height=2)
label2.place(x=660, y=70)

txtfld2=Entry(text="no2", bd=5)
txtfld2.place(x=770, y=70)


label3 = Label(text="Number",foreground="black",background="mintcream" ,width=15,height=2)
label3.place(x=320, y=135)

txtfld3=Entry(text="no3", bd=5)
txtfld3.place(x=420, y=135)


label4 = Label(text="Department",foreground="black",background="mintcream" ,width=15,height=2)
label4.place(x=660, y=135)

options=["Developer","Coding","Testing","Desiging"]

menu= StringVar()
menu.set("Select Department")

drop= OptionMenu(window, menu,*options)
drop.pack()
drop.place(x=770, y=135)

label5 = Label(text="Mail Id",foreground="black",background="mintcream" ,width=15,height=2)
label5.place(x=320, y=200)

txtfld5=Entry(text="no5", bd=5)
txtfld5.place(x=420, y=200)


label6 = Label(text="Experience",foreground="black",background="mintcream" ,width=15,height=2)
label6.place(x=660, y=200)

txtfld6=Entry(text="no6", bd=5)
txtfld6.place(x=770, y=200)


label7 = Label(text="DOB",foreground="black",background="mintcream" ,width=15,height=2)
label7.place(x=320, y=265)

txtfld7=Entry(text="no7", bd=5)
txtfld7.place(x=420, y=265)


label8 = Label(text="Salary",foreground="black",background="mintcream" ,width=15,height=2)
label8.place(x=660, y=265)

txtfld8=Entry(text="no8", bd=5)
txtfld8.place(x=770, y=265)

label9 = Label(text="Age",foreground="black",background="mintcream" ,width=15,height=2)
label9.place(x=320, y=320)

txtfld9=Entry(text="no9", bd=5)
txtfld9.place(x=420, y=320)


label10 = Label(text="Skills",foreground="black",background="mintcream" ,width=15,height=2)
label10.place(x=660, y=320)

txtfld10=Entry(text="no10", bd=5)
txtfld10.place(x=770, y=320)

label11 = Label(text="Gender",foreground="black",background="mintcream" ,width=15,height=2)
label11.place(x=320, y=380)

radio = IntVar()  

R1 = Radiobutton(window, text="Male",variable=radio, value=1)
R1.pack( anchor = W )
R1.place(x=420,y=390)

R2 = Radiobutton(window, text="Female",variable=radio, value=2)
R2.pack( anchor = W )
R2.place(x=490,y=390)

R3 = Radiobutton(window, text="Other",variable=radio, value=3)
R3.pack( anchor = W )
R3.place(x=570,y=390)

label14 = Label(text="Role",foreground="black",background="mintcream" ,width=15,height=2)
label14.place(x=660, y=380)

txtfld14=Entry(text="no10", bd=5)
txtfld14.place(x=770, y=380)


btn1=Button(text="Save",fg='orange',width="10",height="2")
btn1.place(x=530,y=450)

btn1=Button(text="Ok",fg='orange',width="10",height="2")
btn1.place(x=690,y=450)

window.mainloop()
