// PROBLEM : Delete Nodes with Greater on Right


// SOLUTION :
'''
Structure of linked list node
class Node:
    def __init__(self,x):
        self.data=x
        self.next=None

'''
class Solution:
    def compute(self,head):
        stk=[]
        cur=head
        while cur:
            while stk and stk[-1].data<cur.data:
                stk.pop()
            stk.append(cur)
            cur=cur.next
        for ix in range(len(stk)-1):
            stk[ix].next=stk[ix+1]
        stk[-1].next=None
        return stk[0]
