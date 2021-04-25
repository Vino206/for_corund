"""
Модуль с основным классом-конструктором Game - для создания игры.
"""

import pygame


class Game:
    """
    Класс-конструктор, содержит основные методы и переменные для написания игр
    """
    RUNNER = True

    __clock = pygame.time.Clock()  # счетчик FPS

    def __init__(self, width=400, height=300, color=(0, 0, 0)):
        """
        :parameter width: высота окна
        :parameter height: ширина окна
        """
        self.color = color

        self.surface = pygame.display.set_mode(
            size=(width, height)
        )  # родительское окно
        self.surface.fill(color)
        self.body = self.surface.get_rect()

    @staticmethod
    def display_update():
        pygame.display.update()

    @staticmethod
    def events():
        return pygame.event.get()

    def window_fill(self):
        """
        Метод при вызове которого заливается родительское окно
        :return: None
        """
        self.surface.fill(self.color)  # заливаем родительское окно

    def fps_counter(self, FPS=30) -> None:
        """
        Метод уравляущий частотой обновления кадров
        :param FPS: число кадров в секунду
        :return: None
        """
        self.__clock.tick(FPS)

    def close(self, event) -> None:
        if event.type == 256 or (event.type == 768 and event.key == 27):  # если нажал крестик или ESC
            pygame.quit()  # деинициализируем pygame
            self.RUNNER = False  # отключаем цикл

    def window_borders(self, obj):
        if obj.body.bottom > self.body.bottom:
            obj.body.bottom = self.body.bottom
        elif obj.body.top < self.body.top:
            obj.body.top = self.body.top
        if obj.body.right > self.body.right:
            obj.body.right = self.body.right
        elif obj.body.left < self.body.left:
            obj.body.left = self.body.left
