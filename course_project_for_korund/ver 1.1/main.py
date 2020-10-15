from tkinter import *
from datetime import datetime

from support import date_type

import pandas as pd


def collect_data():
    """get data and collect it in data base"""

    # BASE VARIABLES
    data = {}  # init dict for data

    # DATA FROM STRINGS
    name = ent_name.get()  # get name
    data['ФИО'] = name  # collect in dict

    b_date = ent_b_date.get()  # get birth date
    data['Дата рождения'] = date_type(b_date)  # collect in dict

    datetime_now = datetime.now()  # get today date
    data['Дата регистрации'] = datetime_now.date()  # get date only

    age = (data['Дата регистрации'] - data['Дата рождения']) / 365.25  # calculate age
    data['Возраст'] = age.days  # days out

    interest_list = flags_data()
    data['Интересы'] = ', '.join(interest_list)

    global df
    df = df.append(data, ignore_index=True)

    # clean_data()


def clean_data():
    ent_name.delete(0, END)
    ent_b_date.delete(0, END)
    i = 0
    while i < len(booleans_interest):
        booleans_interest[i].set(0)
        i += 1


def flags_data():
    interest_list = []
    i = 0
    while i < len(booleans_interest):
        bool_interest = booleans_interest[i]
        if bool_interest.get() == 1:
            interest_list.append(interest_names[i])
        i += 1

    return interest_list


def top_open():
    top_frame.pack(side=TOP, anchor=W, pady=10)

    lbl_name.grid(row=0, column=0, sticky=E)
    ent_name.grid(row=0, column=1, sticky=W, padx=10)

    lbl_b_date.grid(row=1, column=0, sticky=E)
    ent_b_date.grid(row=1, column=1, sticky=W, padx=10)


def interest_open():
    interest_frame.pack(side=TOP, anchor=W)

    interest_lbl.pack(side=TOP, anchor=W)

    i = 0
    while i < len(flags):
        flags[i].pack(side=TOP, anchor=W)
        i += 1


def buttons_open():
    but_frame.pack(side=TOP, anchor=E)

    but_data.pack(side=LEFT, pady=10)
    but_close.pack(side=LEFT, padx=10, pady=10)


def create_flag(master, name):
    boolean = BooleanVar()
    boolean.set(0)
    flag = Checkbutton(master=master, text=name, variable=boolean, onvalue=1, offvalue=0)

    return flag, boolean


# INIT DATABASE
columns = ['ФИО', 'Возраст', 'Дата рождения', 'Интересы', 'Дата регистрации']
df = pd.DataFrame(columns=columns)

# INIT MASTER
root = Tk()
root.title('Регистрация клиентов')  # rename master window

# BASE DATA
top_frame = Frame(master=root)
# STRING NAME
lbl_name = Label(master=top_frame, text='Введите ФИО:')
ent_name = Entry(master=top_frame, width=40)
# STRING BIRTH DATE
lbl_b_date = Label(master=top_frame, text='Введите дату рождения:')
ent_b_date = Entry(master=top_frame, width=40)

# CHOICE INTEREST
interest_frame = Frame(master=root)
interest_lbl = Label(master=interest_frame, text='Выберите интересы:')
# INTEREST LIST
interest_names = 'Наука', 'Техника', 'Икусство', 'Путешествие', 'Спорт', 'Другое'
# CREATE FLAGS
flag_sc, bool_sc = create_flag(master=interest_frame, name=interest_names[0])
flag_tech, bool_tech = create_flag(master=interest_frame, name=interest_names[1])
flag_art, bool_art = create_flag(master=interest_frame, name=interest_names[2])
flag_tr, bool_tr = create_flag(master=interest_frame, name=interest_names[3])
flag_sp, bool_sp = create_flag(master=interest_frame, name=interest_names[4])
flag_an, bool_an = create_flag(master=interest_frame, name=interest_names[5])
# PACK FLAGS IN VARIABLE
flags = flag_sc, flag_tech, flag_art, flag_tr, flag_sp, flag_an
booleans_interest = bool_sc, bool_tech, bool_art, bool_tr, bool_sp, bool_an

# BUTTON GET DATA
but_frame = Frame(master=root)
# COMMANDS
but_data = Button(master=but_frame, text='Enter', width=10, command=collect_data)
but_close = Button(master=but_frame, text='Close', width=10, command=root.destroy)

# OPEN PEACES
top_open()
interest_open()
buttons_open()

# OPEN WINDOWS
root.mainloop()
df = df.drop_duplicates(subset=columns[:-2], keep='last')
