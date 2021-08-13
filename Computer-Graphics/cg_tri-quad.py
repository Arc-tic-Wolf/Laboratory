from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *


def drawTriangle(x1,y1,x2,y2,x3,y3):
    glBegin(GL_TRIANGLES)
    #3 vertices
    glVertex2f(x1,y1)   
    glVertex2f(x2,y2)   
    glVertex2f(x3,y3)   
    glEnd()

def drawQuad(x1,y1,x2,y2,x3,y3,x4,y4):
    glBegin(GL_QUADS)
    #vertices must be anticlockwise ordered
    glVertex2f(x1,y1) 
    glVertex2f(x2,y2)
    glVertex2f(x3,y3)
    glVertex2f(x4,y4) 
    glEnd()

def iterate():
    glViewport(0, 0, 500, 500)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0.0, 500, 0.0, 500, 0.0, 1.0)
    glMatrixMode (GL_MODELVIEW)
    glLoadIdentity()

def showScreen():
    # glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    iterate()
    #draw methods seperated by color
    glColor3f(0.0,1.0,1.0)
    drawTriangle(100,250,250,250,175,350)
    glColor3f(1.0,0.0,1.0)
    drawQuad(100,100,100,250,250,250,250,100)
    glColor3f(1.0,1.0,0.0)
    drawQuad(160,100,160,150,190,150,190,100)
    drawQuad(130,200,130,220,150,220,150,200)
    drawQuad(200,200,200,220,220,220,220,200)
    glutSwapBuffers()

glutInit()
glutInitDisplayMode(GLUT_RGBA)
glutInitWindowSize(500, 500)
glutInitWindowPosition(0, 0)
wind = glutCreateWindow(b"Computer Graphics 001")
glutDisplayFunc(showScreen)
glutIdleFunc(showScreen)
glutMainLoop()