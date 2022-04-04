#ifndef UTIIL_H
#define UTIIL_H



namespace Utiil {
class Utiil{

public:
    static int char16_lenth(const char16_t *s);


private:
};


int Utiil::char16_lenth(const char16_t *s)
{
    int cnt = 0;
    while (*s++) cnt++;
    return cnt;
}

}







#endif // UTIIL_H


