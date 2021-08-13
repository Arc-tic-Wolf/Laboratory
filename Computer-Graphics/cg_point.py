from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random

def drawPoint():
    glBegin(GL_POINTS)
    for i in range(50):
        glVertex2f(a[i][0],a[i][1])
    glEnd()

def iterate():
    glViewport(0, 0, 500, 500)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0.0, 500, 0.0, 500, 0.0, 1.0)
    glMatrixMode (GL_MODELVIEW)
    glLoadIdentity()

def showScreen():
    glLoadIdentity()
    iterate()
    glColor3f(0.0, 3.0, 1.0)
    drawPoint()
    glutSwapBuffers()

a=[[random.randint(1,499),random.randint(1,499)] for i in range(50)]
glutInit()
glutInitDisplayMode(GLUT_RGBA)
glutInitWindowSize(500, 500)
glutInitWindowPosition(0, 0)
wind = glutCreateWindow(b"Computer Graphics 001")
glutDisplayFunc(showScreen)
glutIdleFunc(showScreen)
glutMainLoop()
