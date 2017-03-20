#!/usr/bin/python

import sys


import datetime
import locale

current = datetime.datetime.now()


tahun = current.year
bulan = current.month
hari = current.day

jam = current.hour
menit = current.minute
detik = current.second

print 'Number of arguments:', len(sys.argv), 'arguments.'
print 'Argument List:', str(sys.argv)

date_string = "{}-{}-{} {}:{}:{}".format(hari, bulan, tahun,jam,menit,detik)
print date_string
